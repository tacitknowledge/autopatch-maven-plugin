Maven Autopatch plugin
======================
Maven plugin allows you to apply database patches with [Autopatch] (https://github.com/tacitknowledge/autopatch) during
any Maven project lifetime cycle.

Goals
-----

* **patch** - Goal which applies patches found in the classpath
* **info** - Goal which provides patch information.
* **unlock** -  Goal which forcibly unlocks a patch table that has an orphan lock.

The next set of goals work for multiple system names at once. You should specify orchestration patch store system name.

* **distributed-patch** - Goal which applies patches found in the classpath.
* **distributed-info** -  Goal which provides patch information.
* **distributed-unlock** - Goal which forcibly unlocks a patch table that has an orphan lock.

Properties
----------

<table>
<tr><th>Name</th><th>Description</th><th>Default value</th></tr>
<tr><td>skip</td><td>skips the execution. TODO: implement</td><td>false</td></tr>
<tr><td>classpathElements</td><td>a list specifying classpath folders where plugin will look for patches.</td>
    <td>${project.compileClasspathElements}</td></tr>
<tr><td>migrationSettings</td><td>the migration settings file</td><td>"migration.properties"</td></tr>
<tr><td>systemName</td><td>The system to get patch information about</td><td></td></tr>
</table>

POM usage:
----------

    <properties>
      <autopatch.system.name>integration_test</autopatch.system.name>
      <autopatch.migration.settings></autopatch.migration.settings>
    </properties>

    <plugin>
      <groupId>com.tacitknowledge</groupId>
      <artifactId>tk-autopatch-maven-plugin</artifactId>
      <version>1.3.0</version>
      <configuration>
        <!-- The location of the patches -->
        <classpathElements>
            <param>${basedir}/target/test-classes</param>
        </classpathElements>
        <!-- Custom migration settings file -->
        <migrationSettings>migration-distributed.properties</migrationSettings>
        <!-- The system name to run tests on -->
        <systemName>integration_test</systemName>
      </configuration>
      <executions>
        <execution>
          <phase>unlock</phase>
          <goals>
            <goal>distributed-info</goal>
          </goals>
        </execution>
      </executions>
    </plugin>

    <build>
      <plugins>
        <plugin>
          <groupId>com.tacitknowledge</groupId>
          <artifactId>tk-autopatch-maven-plugin</artifactId>
          <version>1.4.1</version>
          <executions>
            <execution>
              <phase>install</phase>
              <goals>
                <goal>distributed-patch</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
      </plugins>
    </build>




