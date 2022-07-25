import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { ApolloClient, InMemoryCache } from '@apollo/client/core';
import { ApolloProvider } from '@apollo/client/react';

import './index.css';
import App from './App';

const client = new ApolloClient({
  uri: 'http://54.180.29.85:8080/graphqls/',
  cache: new InMemoryCache(),
});

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <React.StrictMode>
      <ApolloProvider client={client}>
        <App />
      </ApolloProvider>
    </React.StrictMode>
  </BrowserRouter>,
);
