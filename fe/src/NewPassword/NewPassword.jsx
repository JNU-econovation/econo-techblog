import React, { useEffect, useState } from 'react';

import InputElement from '../components/InputElement';
import { isEmptyStatus, isSamePasswd } from '../SignUp/util/VerifyPassword';
import './NewPassword.css';

function ResetPassword() {
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [passwordStatus, setPasswordStatus] = useState('');

  useEffect(() => {
    if (isEmptyStatus(password, confirmPassword)) {
      setPasswordStatus('');
    } else if (isSamePasswd(password, confirmPassword)) {
      setPasswordStatus('비밀번호가 일치합니다.');
    } else {
      setPasswordStatus('비밀번호가 일치하지 않습니다.');
    }
  }, [password, confirmPassword]);
  return (
    <div className="new-password">
      <div className="new-password-box">
        <div className="new-password__title">비밀번호 재설정</div>
        <p>새로운 비밀번호를 설정해주세요.</p>
        <InputElement
          type="password"
          classNames="new-password__input"
          placeHolder="비밀번호"
          value={password}
          setValue={setPassword}
        />
        <InputElement
          type="password"
          classNames="new-password__input--confirm"
          placeHolder="비밀번호 확인"
          value={confirmPassword}
          setValue={setConfirmPassword}
        />
        <span>{passwordStatus}</span>
        <button type="button" className="new-password__button--submit">
          수정 완료
        </button>
      </div>
    </div>
  );
}

export default ResetPassword;
