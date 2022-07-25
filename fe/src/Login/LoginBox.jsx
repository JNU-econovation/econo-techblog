import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

import InputElement from '../components/InputElement';
import SignUpLinkBtn from './SignUpLinkBtn';
import LoginLink from './LoginLink';
import { useLoginDispatchContext } from '../Context/LoginContext';
import './css/LoginBox.css';

function LoginBox() {
  const navigate = useNavigate();
  const loginDispatch = useLoginDispatchContext();

  const [userEmail, setUserEmail] = useState('');
  const [password, setPassword] = useState('');
  const [isLoginFail, setIsLoginFail] = useState(true);

  const onLoginClick = () => {
    const form = new FormData();
    form.append('userEmail', userEmail);
    form.append('password', password);
    console.log('requestFormData', form);

    axios({
      method: 'post',
      url: '/api/login',
      data: form,
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
        'Content-Type': '*',
      },
    })
      .then((response) => {
        loginDispatch({ type: 'LOGIN', ...response.data });
        sessionStorage.setItem('uid', response.data.id);
        navigate('/');
      })
      .catch((error) => {
        console.log('error', error);
        setIsLoginFail(() => false);
      });
  };

  return (
    <div className="login-box">
      <h3 className="login-box__title">Sign in</h3>
      <InputElement
        classNames="login-box-id__input"
        placeHolder="ID"
        value={userEmail}
        setValue={setUserEmail}
      />
      <InputElement
        classNames="login-box-pw__input"
        placeHolder="Password"
        value={password}
        setValue={setPassword}
        type="password"
      />
      {!isLoginFail ? (
        <p className="login-fail">
          이메일 또는 비밀번호를 다시한번 확인해주세요
        </p>
      ) : undefined}
      <button className="login__button" type="submit" onClick={onLoginClick}>
        로그인
      </button>
      <SignUpLinkBtn />
      <LoginLink />
    </div>
  );
}

export default LoginBox;
