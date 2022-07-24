import React from 'react';
import { useNavigate } from 'react-router-dom';

import './css/SignUpLinkBtn.css';

function SignUpLinkBtn() {
  const navigate = useNavigate();
  const onClick = () => {
    navigate('/signup');
  };

  return (
    <button type="button" className="sign-up-link__button" onClick={onClick}>
      회원가입
    </button>
  );
}

export default SignUpLinkBtn;
