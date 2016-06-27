mkdir -p bin
rm -r bin/*
javac @options @classes
jar cfv yt-lib.jar -C  bin .
rm -r bin/*
mv yt-lib.jar bin/
