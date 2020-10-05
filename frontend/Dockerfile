FROM node:14.11.0-alpine as build
WORKDIR /app
ARG service_url='localhost:8080'
ENV SERVICE_URL=$service_url
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json /app/package.json
RUN npm install --silent
RUN npm install react-scripts@3.1.1 -g --silent
COPY . /app
RUN npm run build

# production environment
FROM nginx:1.19.2-alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]