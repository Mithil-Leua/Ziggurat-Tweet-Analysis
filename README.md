# Sentiment Analyzer

## Description
It reads from messages the Kafka topic which the tweet producer pushed to. Then it parses the tweet to get the content of the tweet and does sentimental analysis using Stanford CoreNLP library. 
Library analyzes a sentence rather than a text, so it aggregates the sentiment for the tweet as a whole and shows the results on console.

## Pre requisites

You need to run the docker first. 
```
docker-compose up
```
To produce tweets to the topic configured in `resources/config.edn` file, run the program over [here](https://github.com/Mithil-Leua/Tweet-Producer).
Make sure the topic in the Kafka topic and broker match for this project and [this](https://github.com/Mithil-Leua/Tweet-Producer) project.

## Build Jar

clone the project, `cd` to project directory and run the command
```
lein uberjar
```

### Run

Configure your Kafka topic, Kafka broker in `resources/config.edn` file. Read more [here](https://github.com/gojek/ziggurat#configuration).
clone the project and run the project using:
```
lein run
```

OR

If you do not have lein installed in your system, clone the repo and find the standalone jar in `target/uberjar` directory.
Make java execute the jar as follows.
```
java -jar target/uberjar/sentiment-0.1.0-SNAPSHOT-standalone.jar
```


## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
