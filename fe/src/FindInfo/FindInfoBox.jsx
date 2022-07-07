import React, { useState } from 'react';

import CardinalSelectBox from '../components/CardinalSelectBox';
import InputElement from '../components/InputElement';
import FindIdBtn from './FindIdBtn';
import './css/FindInfoBox.css';

function FindInfoBox() {
  const [name, setName] = useState('');

  return (
    <div className="find-info-box">
      <h3 className="find-info-box-title">아이디 찾기</h3>
      <InputElement
        placeHolder="이름"
        value={name}
        setValue={setName}
        type="text"
      />
      <CardinalSelectBox />
      <FindIdBtn />
    </div>
  );
}

export default FindInfoBox;
