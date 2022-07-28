import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { ApolloClient, InMemoryCache } from '@apollo/client/core';
import { ApolloProvider } from '@apollo/client/react';

import './index.css';
import App from './App';
import { LoginProvider } from './Context/LoginContext';

const client = new ApolloClient({
  uri: 'http://168.131.30.127:8080/graphqls/',
  cache: new InMemoryCache(),
});

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <LoginProvider>
    <BrowserRouter>
      <React.StrictMode>
        <ApolloProvider client={client}>
          <App />
        </ApolloProvider>
      </React.StrictMode>
    </BrowserRouter>
  </LoginProvider>,
);
