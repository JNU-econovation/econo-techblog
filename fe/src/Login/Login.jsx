import React from 'react';

import LoginBox from './LoginBox';
import MainLogo from './img/logo.png';
import './css/Login.css';

function Login() {
  return (
    <div className="login">
      <img src={MainLogo} className="main-logo" alt="main-logo" />
      <LoginBox />
    </div>
  );
}

export default Login;
