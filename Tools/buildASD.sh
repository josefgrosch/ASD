#!/bin/sh

cd ../ASD
mvn -Dshow=private  clean javadoc:jar package install
