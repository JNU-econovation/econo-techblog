import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { ApolloClient, InMemoryCache } from '@apollo/client/core';
import { ApolloProvider } from '@apollo/client/react';

import './index.css';
import App from './App';

const client = new ApolloClient({
  uri: 'http://13.124.120.174/graphql/',
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
