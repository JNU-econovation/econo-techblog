/* eslint-disable */
import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/SidebarItem.css';

import person from '../img/ID.png';

const SidebarItem = function ({ id, name, num, isSelected, onClick }) {
  return (
    <li
      className={isSelected ? 'sidebar-item selected' : 'sidebar-item'}
      onClick={() => onClick(id)}
    >
      <span>{name}</span>
      <div className="sidebar-item-right">
        <img src={person} alt="person" />
        <span>{num}</span>
      </div>
    </li>
  );
};

SidebarItem.propTypes = {
  id: PropTypes.number.isRequired,
  name: PropTypes.string.isRequired,
  num: PropTypes.number.isRequired,
  isSelected: PropTypes.bool.isRequired,
  onClick: PropTypes.func.isRequired,
};

export default SidebarItem;
