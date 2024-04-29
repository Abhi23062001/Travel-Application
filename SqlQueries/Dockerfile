FROM mysql

LABEL authors="Abhishek"

WORKDIR /mysql

COPY . /mysql

USER root

RUN chmod -R 777 /mysql

CMD ["mysql", "-u", "root", "-p1234"]

CMD ["source", "/mysql/travelApp.sql"]
