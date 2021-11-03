package com.example.Mutant.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


@AnalyzeClasses(packages="com.example.Mutant",importOptions=ImportOption.DoNotIncludeTests.class)
public class ArchUnitTest {



    @ArchTest
    public static final    ArchRule layerRule = layeredArchitecture()


            .layer("Controller").definedBy("com.example.Mutant.controllers")
            .layer("Service").definedBy("com.example.Mutant.services")
            .layer("Persistence").definedBy("com.example.Mutant.repositories")

            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");


    @ArchTest
    public static final ArchRule controllerNameRule =

            ArchRuleDefinition.classes().that().haveSimpleNameEndingWith("Controller").should().resideInAPackage("com.example.Mutant.controllers");

}