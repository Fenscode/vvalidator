/**
 * Designed and developed by Aidan Follestad (@afollestad)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("unused")

package com.afollestad.vvalidator.field.spinner

import android.widget.Spinner
import com.afollestad.vvalidator.ValidationContainer
import com.afollestad.vvalidator.assertion.CustomViewAssertion
import com.afollestad.vvalidator.assertion.spinner.SpinnerAssertions.SelectionAssertion
import com.afollestad.vvalidator.field.FieldValue
import com.afollestad.vvalidator.field.FormField
import com.afollestad.vvalidator.field.IntFieldValue

/**
 * Represents a spinner (dropdown) field.
 *
 * @author Aidan Follestad (@afollestad)
 */
class SpinnerField internal constructor(
  container: ValidationContainer,
  view: Spinner,
  name: String?
) : FormField<SpinnerField, Spinner, Int>(container, view, name) {

  /** Asserts on the spinner's selection. */
  fun selection() = assert(SelectionAssertion())

  /** Adds a custom inline assertion for the spinner. */
  fun assert(
    description: String,
    matcher: (Spinner) -> Boolean
  ) = assert(CustomViewAssertion(description, matcher))

  /** Returns a snapshot of [Spinner.getSelectedItemPosition]. **/
  override fun obtainValue(
    id: Int,
    name: String
  ): FieldValue<Int>? {
    return IntFieldValue(
        id = id,
        name = name,
        value = view.selectedItemPosition
    )
  }
}
