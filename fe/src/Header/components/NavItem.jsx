import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './NavItem.css';

function NavItem({ navName }) {
  return <li className="nav-item">{navName}</li>;
}

NavItem.propTypes = {
  navName: PropTypes.string.isRequired,
};

export default NavItem;
