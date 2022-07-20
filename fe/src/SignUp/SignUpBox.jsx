import React, { useState, useEffect } from 'react';

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

  const onSubmit = () => {
    const requestData = {
      userEmail,
      password,
      year,
      userName,
      pinCode: 1111,
    };
    console.log('verify request data', requestData);
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
