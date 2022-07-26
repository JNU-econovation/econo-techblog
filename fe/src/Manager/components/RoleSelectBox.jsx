/* eslint-disable jsx-a11y/no-noninteractive-element-interactions */
/* eslint-disable jsx-a11y/click-events-have-key-events */
import React, { useState } from 'react';

import '../css/RoleSelectBox.css';
import select from '../img/select_more.png';

const RoleSelectBox = function () {
  const [open, setOpen] = useState(false);
  const [option, setOption] = useState('권한');
  const onOpen = () => {
    setOpen(!open);
  };
  const onClick = (item) => {
    setOption(item.target.innerText);
    setOpen(false);
  };
  return (
    <div className="role-select-box">
      <button
        type="button"
        className="role-select-box__current"
        onClick={onOpen}
      >
        <span>{option}</span>
        <img src={select} alt="select more" className="role-select-box__img" />
      </button>
      <ul
        className={
          open
            ? 'role-select-box__list role-select-box__list--open'
            : 'role-select-box__list'
        }
      >
        <li className="role-select-box__item" onClick={onClick}>
          게스트 회원
        </li>
        <li className="role-select-box__item" onClick={onClick}>
          일반 회원
        </li>
        <li className="role-select-box__item" onClick={onClick}>
          관리자 회원
        </li>
      </ul>
    </div>
  );
};

export default RoleSelectBox;
