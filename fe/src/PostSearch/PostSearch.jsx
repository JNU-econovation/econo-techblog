import React, { useState } from 'react';

import './css/PostSearch.css';
import TagSearch from './components/TagSearch';
import SearchResult from './components/SearchResult';

const PostSearch = function () {
  const [text, setText] = useState('');
  return (
    <div className="post-search">
      <div className="post-search-top">
        <TagSearch setValue={setText} value={text} />
      </div>
      <SearchResult keyword="C++" />
    </div>
  );
};

export default PostSearch;
