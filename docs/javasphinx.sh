#!/bin/bash
# Script to generate Javadoc output for sphinx with javasphinx-apidoc

# add packagename in the first line of each java file
ls -f ../src/main/java/*.java | while read -r file; do
    sed  -i '1i package com.linuxluigi.polynomial;' $file
done

ls -f ../src/test/java/*.java | while read -r file; do
    sed  -i '1i package com.linuxluigi.polynomial.test;' $file
done

# convert javadoc to rst files
javasphinx-apidoc -o source/ --title='Polynomials Calculator' ../src -u

# convert source to build files
make html
make epub
make epub3
make man
make latex

# remove packagename of each java file
ls -f ../src/main/java/*.java | while read -r file; do
    sed -i '1d' $file
done

ls -f ../src/test/java/*.java | while read -r file; do
    sed -i '1d' $file
done

exit 0