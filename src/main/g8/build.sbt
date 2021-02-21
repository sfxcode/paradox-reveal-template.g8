lazy val presentation = (project in file("."))
  .enablePlugins(ParadoxRevealPlugin)
  .enablePlugins(ParadoxSitePlugin)
  .settings(
    name := "$name$",
    publish / skip := true,
    // add dependencies if needed
    // libraryDependencies += "com.example" %% "example-lib-scala" % "1.0.0",
    Compile / paradoxRevealTheme ~= {
      _.withTheme(ParadoxRevealTheme.ThemeMoon) // choose theme
        .withDefaultTransition(
          ParadoxRevealTheme.TransitionSlide
        ) // choose transition
      // .withMathPlugin // add plugin if needed
      // .withTailwindPlugin // add plugin if needed
    },
    // exclude includes folder
    (Compile / paradoxMarkdownToHtml / excludeFilter) :=
      (Compile / paradoxMarkdownToHtml / excludeFilter).value ||
        ParadoxPlugin.InDirectoryFilter(
          (Compile / paradox / sourceDirectory).value / "includes"
        )
  )
