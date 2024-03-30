package com.example

import scala.deriving.Mirror
import scala.compiletime.{erasedValue, summonFrom, summonInline}

object Macros {

  // This code is from:
  // https://xuwei-k.hatenablog.com/entry/2021/02/21/105201
  inline def values[A](using A: Mirror.SumOf[A]): List[A] =
    summonValues[A.MirroredElemTypes].asInstanceOf[List[A]]

  inline def summonValues[T <: Tuple]: List[Any] =
    inline erasedValue[T] match {
      case _: EmptyTuple =>
        Nil
      case _: (t *: ts) =>
        summonInline[ValueOf[t]].value :: summonValues[ts]
    }

  inline def collect[A](using A: Mirror.SumOf[A]): List[A] =
    collectImpl[A.MirroredElemTypes].asInstanceOf[List[A]]

  inline def collectImpl[T <: Tuple]: List[Any] =
    inline erasedValue[T] match {
      case _: EmptyTuple =>
        Nil
      case _: (t *: ts) =>
        summonFrom {
          case v: ValueOf[`t`] => v.value :: collectImpl[ts]
          case _ => collectImpl[ts]
        }
    }

}
