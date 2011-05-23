/* Copyright 2004 Tacit Knowledge
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

package com.tacitknowledge.autopatch.maven.integration;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.plugin.Mojo;

import java.io.File;

public class PatchUnlockMojoTest extends AbstractMojoTestCase {
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Tests the proper run and configuration of the mojo
     *
     * @throws Exception when errors occures
     */
    public void testCompilerTestEnvironment() throws Exception {
        File pom = new File(getBasedir(), "target/test-classes/plugin-config.xml");
        Mojo mojo = lookupMojo("unlock", pom);
        mojo.execute();
    }
}