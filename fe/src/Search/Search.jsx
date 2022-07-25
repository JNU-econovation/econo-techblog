import React, { useState } from 'react';

import './css/Search.css';
import TagSearch from './components/TagSearch';
import SearchResult from './components/SearchResult';

const Search = function () {
  const [text, setText] = useState('');
  return (
    <div className="search">
      <div className="search-top">
        <TagSearch setValue={setText} value={text} />
      </div>
      <SearchResult keyword="C++" />
    </div>
  );
};

export default Search;
