package com.example

sealed trait A
case object B extends A
case object C extends A
case object D extends A

sealed trait A2
case object B2 extends A2
case object C2 extends A2
case object D2 extends A2
case class E2(a: Int) extends A2

