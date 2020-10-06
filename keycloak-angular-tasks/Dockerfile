FROM node:12.16.1

#RUN npm config set strict-ssl false && npm config set proxy http://proxy.xxxxxx.com:8080

RUN npm config set strict-ssl false 

# get the app
WORKDIR /src
COPY . .

# install packages
RUN npm i
RUN npm install -g @angular/cli

ENV PORT 4200
EXPOSE $PORT


# start app
CMD ng serve --host 0.0.0.0 --port=${PORT}

