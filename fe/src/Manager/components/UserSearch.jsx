import React, { useState } from 'react';
import '../css/UserSearch.css';

import search from '../img/search.png';

const UserSearch = function () {
  const [user, setUser] = useState('');
  const onChange = (e) => {
    setUser(() => e.target.value);
  };
  return (
    <div className="user-search">
      <img src={search} alt="search" className="user-search__img" />
      <input
        className="user-search__input"
        placeholder="사용자를 검색하시오."
        value={user}
        onChange={onChange}
      />
    </div>
  );
};

export default UserSearch;
