package com.example

import org.scalatest.funsuite.AnyFunSuite

class MacrosTest extends AnyFunSuite {

  test("get children of sealed trait A") {
    val x = Macros.values[A]
    assert(x.toSet == Set(B, C, D))
  }

}
