for((i = 1; ; ++i)); do
    echo $i
    java -classpath . round641_div2.RamdomGen $i > int
     java -classpath . FrogvBruteForce < int > out1
     java -classpath . FROGV < int > out2
     diff -w out1 out2 || break
#    diff -w < \( java -classpath . FrogvBruteForce  < int \) < \( java -classpath . FROGV < int \) || break
done