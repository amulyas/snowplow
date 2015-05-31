/*
 * Copyright (c) 2012-2014 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.snowplowanalytics.snowplow.enrich.common
package enrichments
package registry

// Specs2
import org.specs2.Specification
import org.specs2.scalaz.ValidationMatchers

/**
 * Tests the anonymzeIp function
 */
class JavascriptScriptEnrichmentSpec extends Specification with ValidationMatchers { def is =

  "This is a specification to test the JavascriptScriptEnrichment"     ^
                                                                      p^
    "Compiling an invalid JavaScript script should fail"               ! e1^
                                                                       end

  def e1 = {
    val result = JavascriptScriptEnrichment.compile("[")
    val expected = "Error compiling JavaScript script: [javax.script.ScriptException: sun.org.mozilla.javascript.internal.EvaluatorException: missing ] after element list (<Unknown Source>#5)]"

    result must beFailing(expected)
  }

/*
  def e1 = {

    val script =
      s"""|function process(event) {
          |  var platform = event.getPlatform(),
          |      appId    = event.getApp_id();
          |  if (platform == "server" && appId != "secret") {
          |    throw "Invalid server-side event";
          |  }
          |  return [{"schema": "iglu:com.acme/foo/jsonschema/1-0-0",
          |           "data":   { "" }}] 
          |
          |}
          |""".stripMargin

 */

}
