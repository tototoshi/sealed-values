package com.example

import scala.deriving.Mirror
import scala.compiletime.{erasedValue, summonInline}

// This code is from:
// https://xuwei-k.hatenablog.com/entry/2021/02/21/105201
object Macros {

  inline def values[A](using A: Mirror.SumOf[A]): List[A] =
    summonValues[A.MirroredElemTypes].asInstanceOf[List[A]]

  inline def summonValues[T <: Tuple]: List[Any] =
    inline erasedValue[T] match {
      case _: EmptyTuple =>
        Nil
      case _: (t *: ts) =>
        summonInline[ValueOf[t]].value :: summonValues[ts]
    }
}
