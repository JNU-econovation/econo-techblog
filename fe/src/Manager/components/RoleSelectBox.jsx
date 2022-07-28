/* eslint-disable jsx-a11y/no-noninteractive-element-interactions */
/* eslint-disable jsx-a11y/click-events-have-key-events */
import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/RoleSelectBox.css';
import select from '../img/select_more.png';

const RoleSelectBox = function ({
  isRejectable,
  onOpen,
  onSelect,
  isOpen,
  currentOption,
}) {
  return (
    <div className="role-select-box">
      <button
        type="button"
        className="role-select-box__current"
        onClick={onOpen}
      >
        <span>{currentOption}</span>
        <img src={select} alt="select more" className="role-select-box__img" />
      </button>
      <ul
        className={
          isOpen
            ? 'role-select-box__list role-select-box__list--open'
            : 'role-select-box__list'
        }
      >
        <li className="role-select-box__item" onClick={onSelect}>
          GUEST
        </li>
        <li className="role-select-box__item" onClick={onSelect}>
          USER
        </li>
        <li className="role-select-box__item" onClick={onSelect}>
          ADMIN
        </li>
        <li
          className={isRejectable ? 'role-select-box__item' : 'hidden'}
          onClick={onSelect}
        >
          가입 거절
        </li>
      </ul>
    </div>
  );
};

RoleSelectBox.propTypes = {
  isRejectable: PropTypes.bool.isRequired,
  onOpen: PropTypes.func.isRequired,
  onSelect: PropTypes.func.isRequired,
  isOpen: PropTypes.bool.isRequired,
  currentOption: PropTypes.string.isRequired,
};

export default RoleSelectBox;
