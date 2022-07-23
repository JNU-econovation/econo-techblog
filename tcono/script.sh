./gradlew build -x test
cd build/libs
rm -rf tcono-0.0.1-SNAPSHOT-plain.jar
cd ../..
sudo docker login
sudo docker build --build-arg DEPENDENCY=build/dependency -t blackbean99/t_econo .
sudo docker push blackbean99/t_econo
sudo docker run --cap-add=NET_ADMIN -it -p 8080:8080 blackbean99/t_econo:latest
