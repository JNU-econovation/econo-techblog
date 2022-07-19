import React, { useState } from 'react';

import CardinalSelectBox from '../components/CardinalSelectBox';
import InputElement from '../components/InputElement';
import FindIdBtn from './FindIdBtn';
import './css/FindIDBox.css';

function FindIDBox() {
  const [name, setName] = useState('');
  return (
    <div className="find-id-box">
      <h3 className="find-id-box-title">아이디 찾기</h3>
      <InputElement
        placeHolder="이름"
        value={name}
        setValue={setName}
        classNames="find-id-name__input"
        type="text"
      />
      <CardinalSelectBox classNames="find-id-cardinal__select" />
      <FindIdBtn />
    </div>
  );
}

export default FindIDBox;
