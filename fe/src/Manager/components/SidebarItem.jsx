/* eslint-disable */
import React from 'react';
import { Link } from 'react-router-dom';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/SidebarItem.css';

import people from '../img/people.png';

const SidebarItem = function ({ id, name, num, isSelected, onClick }) {
  return (
    <Link to="/admin/users" style={{ textDecoration: 'none' }}>
      <div
        className={
          isSelected ? 'sidebar-item sidebar-item--selected' : 'sidebar-item'
        }
        onClick={() => onClick(id)}
      >
        <span className="sidebar-item__name">{name}</span>
        <div className="sidebar-item-right">
          <img src={people} alt="person" className="sidebar-item-right__img" />
          <span className="sidebar-item-right__num">{num}</span>
        </div>
      </div>
    </Link>
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
