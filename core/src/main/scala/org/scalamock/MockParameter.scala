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

package org.scalamock

// The dummy argument (eugh!) is necessary to avoid:
//
// [error] double definition:
// [error] constructor MockParameter:(v: T)org.scalamock.MockParameter[T] and
// [error] constructor MockParameter:(value: AnyRef)org.scalamock.MockParameter[T]
// [error] have same type after erasure: (v: java.lang.Object)org.scalamock.MockParameter

class MockParameter[T] protected (private[scalamock] val value: AnyRef, dummy: Boolean = false) {
  
  def this(v: T) = this(v.asInstanceOf[AnyRef])
  
  def this(v: MatchAny) = this(v.asInstanceOf[AnyRef])
  
  override def toString = value.toString
}

class EpsilonMockParameter(value: AnyRef, dummy: Boolean = false) extends MockParameter[Double](value) {
  
  def this(v: MatchEpsilon) = this(v.asInstanceOf[AnyRef])
}
