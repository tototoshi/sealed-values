package com.example

import org.scalatest.funsuite.AnyFunSuite

class MacrosTest extends AnyFunSuite {

  test("get children of sealed trait") {
    val x = Macros.values[A]
    assert(x.toSet == Set(B, C, D))
  }

  test("get children of sealed trait only when the child is a singleton") {
    val x = Macros.collect[A2]
    assert(x.toSet == Set(B2, C2, D2))
  }

}
