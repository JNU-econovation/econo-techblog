import React from 'react';
import { useNavigate } from 'react-router-dom';

import './LoginButton.css';

function LoginButton() {
  const navigate = useNavigate();

  const onClick = () => {
    navigate('/login');
  };

  return (
    <button type="button" className="login-button" onClick={onClick}>
      <span>LOGIN</span>
    </button>
  );
}

export default LoginButton;
