/* eslint-disable */
import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import '../css/Table.css';
import noImg from '../img/no_img.png';
import settings from '../img/settings.png';

const Table = function ({ data }) {
  const columns = ['이름', '이메일', '사용자 타입', '기수', '설정'];
  return (
    <table className="table">
      <colgroup>
        <col width="12%" />
        <col width="40%" />
        <col width="20%" />
        <col width="20%" />
        <col width="8%" />
      </colgroup>
      <thead>
        <tr>
          {columns.map((column) => (
            <th key={column}>{column}</th>
          ))}
        </tr>
      </thead>
      <tbody>
        {data.map(({ name, email, usertype, year }) => (
          <tr key={email} className="table-tr">
            <td>
              <div className="table-td-name">
                <img src={noImg} alt="noImg" />
                <span>{name}</span>
              </div>
            </td>
            <td>{email}</td>
            <td>{usertype}</td>
            <td>{year}</td>
            <td>
              <button type="button" className="table-setting-btn">
                <img src={settings} alt="settings" />
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

Table.propTypes = {
  data: PropTypes.array.isRequired,
};

export default Table;
