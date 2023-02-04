import React, { useEffect, useState } from 'react';
import './RecentPosts.css';
import { gql, useQuery } from '@apollo/client';

import RecentPost from './components/RecentPost';

const GET_POSTS = gql`
  query findAllPosts($mainCategoryNumber: Int!, $page: Int!) {
    findAllPosts(mainCategoryNumber: $mainCategoryNumber, page: $page) {
      postId
      userName
      content
      title
      mainCategoryNumber
      categoryName
      createdDate
      views
      hearts
    }
  }
`;

const RecentPosts = function () {
  const [currentPosts, setCurrentPosts] = useState([]);
  const [currCategory, setCurrCategory] = useState(1);
  const [navArr, setArr] = useState([
    {
      id: 1,
      name: 'Tech',
      active: true,
    },
    {
      id: 2,
      name: 'Culture',
      active: false,
    },
    {
      id: 3,
      name: 'Trouble Shooting',
      active: false,
    },
  ]);
  const { data } = useQuery(GET_POSTS, {
    variables: {
      mainCategoryNumber: currCategory,
      page: 0,
    },
  });
  console.log('recentposts', data);
  useEffect(() => {
    if (data) {
      const slicePosts = data.findAllPosts;
      if (slicePosts.length > 6) {
        setCurrentPosts(slicePosts.slice(0, 7));
      } else {
        setCurrentPosts(slicePosts);
      }
    }
  }, [data, currCategory]);
  const onClick = (id) => {
    setArr(
      navArr.map((item) => {
        const elem = item;
        if (elem.id === id) {
          elem.active = true;
        } else {
          elem.active = false;
        }
        return elem;
      }),
    );
    setCurrCategory(id);
  };
  return (
    <div className="recent-posts">
      <h2 className="recent-posts__title">Recent Posts</h2>
      <div className="recent-posts-nav">
        {navArr.map((elem) => (
          <button
            key={elem.id}
            type="button"
            className={
              elem.active
                ? 'recent-posts__nav-item recent-posts__nav-item--active'
                : 'recent-posts__nav-item'
            }
            onClick={() => onClick(elem.id)}
          >
            {elem.name}
          </button>
        ))}
      </div>
      <div className="recent-posts-box">
        {currentPosts.map((item) => (
          <RecentPost key={item.id} post={item} />
        ))}
      </div>
    </div>
  );
};

export default RecentPosts;
