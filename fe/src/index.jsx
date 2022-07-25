import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';

import './index.css';
import App from './App';
import { LoginProvider } from './Context/LoginContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <LoginProvider>
    <BrowserRouter>
      <React.StrictMode>
        <App />
      </React.StrictMode>
    </BrowserRouter>
  </LoginProvider>,
);
