mvn dependency:copy-dependencies
mkdir -p data
cd data
#java -cp ../target/dependency/hsqldb-2.2.8.jar org.hsqldb.Server
java -cp ../target/dependency/hsqldb-2.3.3.jar org.hsqldb.Server
