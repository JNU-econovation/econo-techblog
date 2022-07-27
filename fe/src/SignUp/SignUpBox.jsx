import React, { useState, useEffect } from 'react';
import axios from 'axios';

import CardinalSelectBox from '../components/CardinalSelectBox';
import InputElement from '../components/InputElement';
import EmailStatus from './EmailStatus';
import { isEmptyStatus, isSamePasswd } from './util/VerifyPassword';
import './css/SignUpBox.css';

function SignUpBox() {
  const [isAgree, setIsAgree] = useState(false);
  const [userEmail, setUserEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPasswd, setconfirmPasswd] = useState('');
  const [userName, setUserName] = useState('');
  // eslint-disable-next-line no-unused-vars
  const [year, setYear] = useState(-1);
  const [passwdStatus, setPasswdStatus] = useState('');
  const [pinCode, setPinCode] = useState('');

  useEffect(() => {
    if (isEmptyStatus(password, confirmPasswd)) {
      setPasswdStatus('');
    } else if (isSamePasswd(password, confirmPasswd)) {
      setPasswdStatus('비밀번호가 일치합니다.');
    } else {
      setPasswdStatus('비밀번호가 일치하지 않습니다.');
    }
  }, [password, confirmPasswd]);

  const onCheckHandler = (e) => {
    setIsAgree(() => e.target.checked);
  };

  const onPincodeHandler = (e) => {
    setPinCode(e.target.value);
  };

  const onKeyUpHandler = (e) => {
    setPinCode(e.target.value.replace(/[^0-9]/g, ''));
  };
  const onSubmit = () => {
    const requestData = {
      userEmail,
      password,
      year,
      userName,
      pinCode,
    };
    console.log('verify request data', requestData);
    axios({
      method: 'post',
      url: 'http://168.131.30.127:8080/api/user?',
      data: requestData,
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
        'Content-Type': '*',
      },
    })
      .then((response) => {
        alert('회원가입 완료. 이메일을 확인해주세요.');
        console.log(response);
      })
      .catch((error) => {
        console.log('error', error);
      });
  };

  return (
    <div className="sign-up-box">
      <h3 className="sign-up-box-title">Sign Up</h3>
      <InputElement
        placeHolder="이메일"
        classNames="sign-up-box-email__input"
        value={userEmail}
        setValue={setUserEmail}
        type="text"
      />
      <EmailStatus email={userEmail} />
      <InputElement
        placeHolder="비밀번호"
        classNames="sign-up-box-password__input"
        value={password}
        setValue={setPassword}
        type="password"
      />
      <InputElement
        placeHolder="비밀번호 확인"
        classNames="sign-up-box-password-confirm__input"
        value={confirmPasswd}
        setValue={setconfirmPasswd}
        type="password"
      />
      <span>{passwdStatus}</span>
      <InputElement
        placeHolder="이름"
        classNames="sign-up-box-name__input"
        value={userName}
        setValue={setUserName}
        type="text"
      />
      <CardinalSelectBox
        classNames="sign-up-box-cardinal__select"
        setValue={setYear}
      />
      <input
        className="sign-up-box-pin-code__input"
        type="text"
        placeholder="PIN CODE"
        maxLength={4}
        value={pinCode}
        onChange={onPincodeHandler}
        onKeyUp={onKeyUpHandler}
      />

      <div className="sign-up-box--agree__container">
        <input type="checkbox" checked={isAgree} onChange={onCheckHandler} />
        <span>이용약관 및 개인정보 처리방침에 동의합니다.</span>
      </div>
      <button className="sign-up__button" type="submit" onClick={onSubmit}>
        가입하기
      </button>
    </div>
  );
}

export default SignUpBox;
