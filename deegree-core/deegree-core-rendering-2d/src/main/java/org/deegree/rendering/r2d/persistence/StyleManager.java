//$HeadURL$
/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2010 by:
 - Department of Geography, University of Bonn -
 and
 - lat/lon GmbH -

 This library is free software; you can redistribute it and/or modify it under
 the terms of the GNU Lesser General Public License as published by the Free
 Software Foundation; either version 2.1 of the License, or (at your option)
 any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 details.
 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation, Inc.,
 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 Contact information:

 lat/lon GmbH
 Aennchenstr. 19, 53177 Bonn
 Germany
 http://lat-lon.de/

 Department of Geography, University of Bonn
 Prof. Dr. Klaus Greve
 Postfach 1147, 53001 Bonn
 Germany
 http://www.geographie.uni-bonn.de/deegree/

 e-mail: info@deegree.org
 ----------------------------------------------------------------------------*/
package org.deegree.rendering.r2d.persistence;

import java.util.ArrayList;
import java.util.List;

import org.deegree.commons.config.DeegreeWorkspace;
import org.deegree.commons.config.ResourceManager;
import org.deegree.commons.config.ResourceManagerMetadata;
import org.deegree.commons.config.ResourceProvider;
import org.deegree.commons.config.ResourceState;
import org.deegree.commons.config.WorkspaceInitializationException;
import org.deegree.commons.utils.ProxyUtils;

/**
 * 
 * Currently a dummy resource manager.
 * 
 * @author <a href="mailto:schmitz@lat-lon.de">Andreas Schmitz</a>
 * @author last edited by: $Author$
 * 
 * @version $Revision$, $Date$
 */
public class StyleManager implements ResourceManager {

    @SuppressWarnings("unchecked")
    public Class<? extends ResourceManager>[] getDependencies() {
        return new Class[] { ProxyUtils.class };
    }

    public ResourceManagerMetadata getMetadata() {
        return new ResourceManagerMetadata() {
            public String getName() {
                return "render styles";
            }

            public String getPath() {
                return "styles";
            }

            public List<ResourceProvider> getResourceProviders() {
                List<ResourceProvider> list = new ArrayList<ResourceProvider>();
                list.add( new SEProvider() );
                list.add( new SLDProvider() );
                return list;
            }
        };
    }

    public void shutdown() {
        // nothing to do currently
    }

    public void startup( DeegreeWorkspace workspace )
                            throws WorkspaceInitializationException {
        // nothing to do currently
    }

    @Override
    public ResourceState getState( String id ) {
        // TODO
        return null;
    }
}
