package ru.kirbri.tests;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
//@SelectPackages("ru.kirbri")
//@IncludePackages({"com.example.app.moduleA", "com.example.app.moduleB"})
//@IncludeClassNamePatterns("^.*Tests?$")
@ExcludeTags("WEB")

public class SuiteDemo {
}
