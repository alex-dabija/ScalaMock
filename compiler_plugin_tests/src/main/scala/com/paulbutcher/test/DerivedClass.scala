// Copyright (c) 2011 Paul Butcher
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package com.paulbutcher.test

class GrandparentClass {
  def grandparentMethod(x: Int) = "grandparent method: "+ x
}

class ParentClass extends GrandparentClass {
  def parentMethod(x: Int) = "parent method: "+ x
}

trait Mixin1 {
  def abstractMixin1Method(x: Int): String
  def concreteMixin1Method(x: Int) = "concrete mixin method: "+ x
}

trait Mixin2 {
  def mixin2Method(x: Int) = "mixin2 method: "+ x
}

class DerivedClass extends ParentClass with Mixin1 with Mixin2 {
  def derivedClassMethod(x: Int) = "derived method: "+ x
  def abstractMixin1Method(x: Int) = "abstract mixin1 method: "+ x
  override def mixin2Method(x: Int) = "overridden mixin2 method: "+ x
}