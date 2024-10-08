#!/bin/bash
#
# Builds a jar sg package
#
name=service-integration
base_dir=..
dir=$(PWD)

base_dir="$(dirname "$dir")"
build_dir=$base_dir/target
jar_filepath=`ls $build_dir/$name*.jar`
jar_filename=$(basename -- "$jar_filepath")
mkdir tmp
cd tmp
jar xvf /Users/mtoure/.m2/repository/com/shajar/spring_rest/1.0-SNAPSHOT/spring_rest-1.0-SNAPSHOT.jar
cp -R -n $build_dir/classes/* BOOT-INF/classes/
cp -R -n $build_dir/lib/* BOOT-INF/lib/
rm BOOT-INF/classes/com/javasneo/todolist/TodoListApplication.class
jar cMf0 $jar_filename *
cp $jar_filename $build_dir/$jar_filename
cd ..
#rm -rf tmp