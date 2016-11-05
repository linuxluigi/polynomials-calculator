#!/bin/bash
# Script to generate Javadoc output for sphinx with javasphinx-apidoc
javasphinx-apidoc -o source/ --title='Polynomials Calculator' ../src/main -u -p com.linuxluigi.polynomials
javasphinx-apidoc -o source/ --title='Polynomials Calculator' ../src/test -u -p com.linuxluigi.polynomials.test
make html
exit 0