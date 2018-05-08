FROM ubuntu:16.04

RUN apt-get update && apt-get install -y \
  libmicrohttpd-dev \
  libjansson-dev \
  libcurl4-gnutls-dev \
  libgnutls28-dev \
  libgcrypt20-dev

COPY ./eschaton /eschaton

COPY ./libs/libjansson.so /usr/lib/libjansson.so

COPY ./libs/libulfius.so /usr/lib/libulfius.so

COPY ./libs/libyder.so /usr/lib/libyder.so

COPY ./libs/liborcania.so /usr/lib/liborcania.so


EXPOSE 8080

ENV LD_LIBRARY_PATH ${LD_LIBRARY_PATH}:/usr/lib

CMD ["/eschaton"]