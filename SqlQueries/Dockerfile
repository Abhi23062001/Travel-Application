FROM mysql

LABEL authors="Abhishek"

WORKDIR /mysql

COPY . /mysql

USER root

RUN chmod -R 777 /mysql

CMD ./create.sh