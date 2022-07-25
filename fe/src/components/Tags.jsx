import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './css/Tags.css';

const Tags = function ({ tags }) {
  const tag = tags ? tags.split(',') : [];
  return (
    <div className="tags">
      {tag.map((elem) => (
        <span key={elem} className="tag">
          {`#${elem}`}
        </span>
      ))}
    </div>
  );
};

Tags.propTypes = {
  tags: PropTypes.string.isRequired,
};

export default Tags;
