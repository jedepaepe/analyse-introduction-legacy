/**
 * Toggle hide property of an element
 * @param {string} elementId is the identifier of the element to toggle
 * @return the new status of display of the element;
 */
function toggleHide(elementId) {
    if(typeof elementId !== 'string') console.log('ERROR - elementId is not a string ' + typeof elementId);
    var style = document.getElementById(elementId).style;
    style.display = (style.display === 'none') ? 'block' : 'none';
    return style.display;
}

function createSvgTag(nav) {
    if (nav.innerHTML.trim() === "") { 
        nav.innerHTML =
'<!-- automatically filled by data-toc attributes -->' +
'<svg class="toc-marker" width="200" height="200" xmlns="http://www.w3.org/2000/svg">' +
    '<path stroke="#444" stroke-width="3" fill="transparent" stroke-dasharray="0, 0, 0, 1000" stroke-linecap="round" stroke-linejoin="round" transform="translate(-0.5, -0.5)" />' +
'</svg>';
    }
}

function createNavigation(nav) {
    createSvgTag(nav);
    var sections = document.querySelectorAll("[data-toc], [data-tc]");
    // doc.
    var level = 0;
    var first = document.createElement('ul');
    var parents = [first];
    var last = first;
    sections.forEach(function(s) {
        var sl = s.getAttribute('data-toc') || s.getAttribute('data-tc');
        var li, ul;
        // same level
        if(sl == level + 1) {           // ! must be ==
            li = createElementLi(s);
            parents[level].appendChild(li);
            last = li;
        }
        // down : new ul 
        else if (sl == level + 2) {     // ! must be ==
            level++;
            ul = document.createElement('ul');
            last.appendChild(ul);
            parents[level] = ul;
            li = createElementLi(s);
            parents[level].appendChild(li);
        }
        // up 
        else if (sl <= level) {
            level = sl - 1;
            li = createElementLi(s);
            parents[level].appendChild(li);
            last = li;
        }
        // abnormal
        else {
            console.error('abnormal level ' + s);
            li = document.createElementLi(s);
            parents[level].appendChild(li);
        }
    });
    nav.appendChild(first);
}

/**
 * @param: section - a JMD section
*/
function createElementLi(section) {
    var li = document.createElement('li');
    var header = section.children[0];
    var text = section.getAttribute('data-toc-text') ||
            header.getAttribute('data-toc-text') || 
            header.innerText;
    var a = createElementA(section.id, text);
    li.appendChild(a);
    return li;
}

function createElementA(ref, text) {
    var a = document.createElement('a');
    a.setAttribute('href', '#' + ref);
    a.innerText = text;
    return a;
}


var toc = document.getElementById('toc');
createNavigation(toc);
var tocPath = document.querySelector('.toc-marker path');
var tocItems;

// Factor of screen size that the element must cross
// before it's considered visible
var TOP_MARGIN = 0.1,
    BOTTOM_MARGIN = 0.2;

var pathLength;

window.addEventListener('resize', drawPath, false);
window.addEventListener('scroll', sync, false);

drawPath();

function drawPath () {
    tocItems = [].slice.call(toc.querySelectorAll('li'));

    // Cache element references and measurements
    tocItems = tocItems.map(function (item) {
        var anchor = item.querySelector('a');
        var target = document.getElementById(anchor.getAttribute('href').slice(1));

        return {
            listItem: item,
            anchor: anchor,
            target: target
        };
    });

    // Remove missing targets
    tocItems = tocItems.filter(function (item) {
        return !!item.target;
    });

    var path = [];
    var pathIndent;

    tocItems.forEach(function (item, i) {
        var x = item.anchor.offsetLeft - 5,
            y = item.anchor.offsetTop,
            height = item.anchor.offsetHeight;

        if (i === 0) {
            path.push('M', x, y, 'L', x, y + height);
            item.pathStart = 0;
        } else {
            // Draw an additional line when there's a change in
            // indent levels
            if (pathIndent !== x) path.push('L', pathIndent, y);

            path.push('L', x, y);

            // Set the current path so that we can measure it
            tocPath.setAttribute('d', path.join(' '));
            item.pathStart = tocPath.getTotalLength() || 0;

            path.push('L', x, y + height);
        }

        pathIndent = x;

        tocPath.setAttribute('d', path.join(' '));
        item.pathEnd = tocPath.getTotalLength();
    });

    pathLength = tocPath.getTotalLength();

    sync();
}

function sync () {
    var windowHeight = window.innerHeight;

    var pathStart = pathLength,
        pathEnd = 0;

    var visibleItems = 0;

    tocItems.forEach(function (item) {
        var targetBounds = item.target.getBoundingClientRect();

        if (targetBounds.bottom > windowHeight * TOP_MARGIN && targetBounds.top < windowHeight * (1 - BOTTOM_MARGIN)) {
            pathStart = Math.min(item.pathStart, pathStart);
            pathEnd = Math.max(item.pathEnd, pathEnd);

            visibleItems += 1;

            item.listItem.classList.add('visible');
        } else {
            item.listItem.classList.remove('visible');
        }
    });

    // Specify the visible path or hide the path altogether
    // if there are no visible items
    if (visibleItems > 0 && pathStart < pathEnd) {
        tocPath.setAttribute('stroke-dashoffset', '1');
        tocPath.setAttribute('stroke-dasharray', '1, ' + pathStart + ', ' + (pathEnd - pathStart) + ', ' + pathLength);
        tocPath.setAttribute('opacity', 1);
    } else {
        tocPath.setAttribute('opacity', 0);
    }
}

function openNav () {
    document.getElementById('toc').style.width = '14em';
    document.body.style.marginLeft = '17em';
}

function closeNav () {
    document.getElementById('toc').style.left = '-20em';
    document.body.style.marginLeft = '0';
    return false;
}

// color code
if (!sdkj) var sdkj = {};
sdkj.language = sdkj.language || document.URL.includes('javascript') ? 'javascript' : 'java';
var codes = document.querySelectorAll('textarea');
for (var i = 0; i < codes.length; ++i) {
    sdkj.language = sdkj.language || codes[i].getAttribute('data-language');
    
    switch (sdkj.language) {
        case 'java':
            CodeMirror.fromTextArea(codes[i], {
                mode: 'text/x-java',
                lineNumbers: true
            });
        break;
        case 'sql':
            CodeMirror.fromTextArea(code[i], {
                mode: 'text/x-sql',
                lineNumbers: true
            });
            break;
        case 'xml':
            CodeMirror.fromTextArea(code[i], {
                mode: 'application/xml',
                lineNumbers: true
            })
        case 'javascript':
        default:
            CodeMirror.fromTextArea(codes[i], {
                lineNumbers: true
            });
    }
}

