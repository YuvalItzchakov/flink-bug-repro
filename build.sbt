import sbt.Keys.version

lazy val circeVersion = "0.13.0"
lazy val flinkVersion = "1.12.0"

lazy val root = (project in file(".")).settings(
  name         := "bug-flink-repro",
  version      := "0.1",
  scalaVersion := "2.12.12",
  Compile / run := Defaults
    .runTask(
      Compile / fullClasspath,
      Compile / run / mainClass,
      Compile / run / runner
    )
    .evaluated,
  libraryDependencies ++= Seq(
    "io.circe"                        %% "circe-generic"                % circeVersion,
    "io.circe"                        %% "circe-parser"                 % circeVersion,
    "io.circe"                        %% "circe-generic-extras"         % circeVersion,
    "org.apache.flink"                %% "flink-table-planner-blink"    % flinkVersion,
    "org.apache.flink"                %% "flink-table-runtime-blink"    % flinkVersion,
    "org.apache.flink"                %% "flink-table-api-scala-bridge" % flinkVersion,
    "org.apache.flink"                 % "flink-s3-fs-hadoop"           % flinkVersion,
    "org.apache.flink"                %% "flink-container"              % flinkVersion,
    "org.apache.flink"                %% "flink-connector-kafka"        % flinkVersion,
    "org.apache.flink"                 % "flink-connector-base"         % flinkVersion,
    "org.apache.flink"                 % "flink-table-common"           % flinkVersion,
    "org.apache.flink"                %% "flink-cep"                    % flinkVersion,
    "org.apache.flink"                 % "flink-csv"                    % flinkVersion,
    "org.apache.flink"                %% "flink-statebackend-rocksdb"   % flinkVersion % "provided",
    "org.apache.flink"                %% "flink-scala"                  % flinkVersion % "provided",
    "org.apache.flink"                %% "flink-streaming-scala"        % flinkVersion % "provided",
    "org.apache.flink"                 % "flink-json"                   % flinkVersion % "provided",
    "org.apache.flink"                 % "flink-avro"                   % flinkVersion % "provided",
    "org.apache.flink"                %% "flink-parquet"                % flinkVersion % "provided",
    "org.apache.flink"                %% "flink-runtime-web"            % flinkVersion % "provided",
    "org.apache.flink"                %% "flink-statebackend-rocksdb"   % flinkVersion % "provided",
    "org.apache.flink"                %% "flink-clients"                % flinkVersion,
    "org.apache.logging.log4j"         % "log4j-api"                    % "2.14.0",
    "org.apache.logging.log4j"        %% "log4j-api-scala"              % "12.0",
    "org.apache.logging.log4j"         % "log4j-core"                   % "2.14.0",
    "org.apache.logging.log4j"         % "log4j-slf4j-impl"             % "2.14.0",
    "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml"      % "2.11.4"
  )
)

Global / cancelable := true

